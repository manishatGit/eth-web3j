package com.knoldus.eth;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

class EthJClient {

    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().sendAsync().get();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("The deploy go-ethereum client version is:::: "+clientVersion);
        Credentials credentials = WalletUtils.loadCredentials
                ("test@12er","/home/manish/gethDataDir/keystore/UTC--2018-09-27T11-23-06.906494210Z--59bd0b9d376281b2c92ec8ed7e528f1b3d3bd064");
        credentials.getAddress();

        EthGetBalance ethGetBalance =
                web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();
        System.out.println("The balance of account :::: " + credentials.getAddress() + "  is:: " + ethGetBalance.getBalance() );
        //Load my smart contract

        System.out.println("The gas limit provided is:::::::: " + DefaultGasProvider.GAS_LIMIT);
        Greeter greeter = Greeter.deploy(web3j, credentials, BigInteger.ONE, BigInteger.valueOf(2100500),"Hello World!").send();
        //Get the greeting message
        String msg = greeter.greet().send();
        System.out.println("I am Greeting.... " + msg );
    }
}
