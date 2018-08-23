package com.knoldus.eth;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

class EthJClient {

    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().sendAsync().get();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("The deploy go-ethereum client version is:::: "+clientVersion);
    }
}
