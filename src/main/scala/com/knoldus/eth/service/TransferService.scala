package com.knoldus.eth.service

import java.math.BigDecimal
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.tx.Transfer
import org.web3j.utils.Convert

class TransferService(web3j: Web3j) {

  def transferEther(web3j: Web3j, credentials: Credentials, toAccount: String, amount: BigDecimal ): TransactionReceipt = {
    Transfer.sendFunds(web3j, credentials, toAccount, amount, Convert.Unit.ETHER).send
  }
}