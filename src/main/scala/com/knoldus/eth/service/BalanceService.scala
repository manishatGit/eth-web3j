package com.knoldus.eth.service

import org.web3j.protocol.Web3j
import org.web3j.protocol.core.{DefaultBlockParameter, DefaultBlockParameterName}

class BalanceService(web3j: Web3j) {
   def getBalance(address: String, blockParameter: DefaultBlockParameter = DefaultBlockParameterName.LATEST): BigInt = {
      web3j.ethGetBalance(address, blockParameter).send().getBalance
   }
}