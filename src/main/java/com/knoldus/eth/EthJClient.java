package com.knoldus.eth;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

class EthJClient {
    public static void main(String[] args) throws Exception {
        String INFURA_CLIENT = "https://ropsten.infura.io/v3/7debdc2003b6449bbcf3a39a0e867af9";
        Web3j web3j = Web3j.build(new HttpService(INFURA_CLIENT));
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().sendAsync().get();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("The deploy go-ethereum client version is:::: "+clientVersion);
        //The below credentials are account credentials which exists on Ropsten Network
        Credentials credentials = WalletUtils.loadCredentials
                ("rops@12er","/home/manish/.ethereum/testnet/keystore/UTC--2018-09-24T06-46-10.776895591Z--d286c7cb356c26ff5d31097fc17aca3dd29f0a51");
        EthGetBalance ethGetBalance =
                web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();
        System.out.println("The balance of account :::: " + credentials.getAddress() + "  is:: " + ethGetBalance.getBalance() );
        System.out.println("Completed Transaction....");
    }
}