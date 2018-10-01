package com.knoldus.eth.demo

import java.math.BigDecimal

import com.knoldus.eth.factory.Web3ClientFactory
import com.knoldus.eth.service.BalanceService
import com.typesafe.config.ConfigFactory
import org.web3j.crypto.{Credentials, WalletUtils}
import org.web3j.tx.Transfer
import org.web3j.utils.Convert

object TransferDemo extends App {

    val config = ConfigFactory.load("application.conf").getConfig("transfer")
    val WALLET_PASSWORD = System.getProperty("password")
    val WALLET_SOURCE = config.getString("walletsource")
    val credentials: Credentials = WalletUtils.loadCredentials(WALLET_PASSWORD, WALLET_SOURCE)
    val INFURA_CLIENT = config.getString("infura")
    val ACCOUNT_TO = config.getString("accountto")
    val ACCOUNT_FROM = credentials.getAddress

    val web3j = Web3ClientFactory(INFURA_CLIENT).getWeb3Client()

    val balanceService = new BalanceService(web3j)

    println("The balance of sending account :::: " + ACCOUNT_FROM + "  is:: " + balanceService.getBalance(ACCOUNT_FROM))

    println("The balance of receiving account :::: " + ACCOUNT_TO + "  is:: " + balanceService.getBalance(ACCOUNT_TO))

    val transactionReceipt = Transfer.sendFunds(web3j, credentials, ACCOUNT_TO, BigDecimal.valueOf(0.0001), Convert.Unit.ETHER).send

    println("The balance of sending account " + ACCOUNT_FROM + "  after sending " + BigDecimal.valueOf(0.0001) + " eth is:: " + balanceService.getBalance(ACCOUNT_FROM))

    println("The balance of receiving account :::: " + ACCOUNT_TO + "  after receiving " + BigDecimal.valueOf(0.0001) + " eth is:: " + balanceService.getBalance(ACCOUNT_TO))

    println("Completed Transfer.... \nstatus =  " + transactionReceipt.getStatus + "\nThe transaction hash " + transactionReceipt.getTransactionHash)

}