## eth-web3j  
A Java Application which connects to go-ethereum client via infura and demonstrate two features.

1. Checking balance of an Ethereum account
2. Transferring funds to another Ethereum account 

## How to configure    

Change the below parameters in application.conf according to your Ethereum account and password related details.   

 `walletsource` : The wallet keypair of the application. If you don't have one, It can be generated using any of the Ethereum wallte clients. eg. My Ethereum wallet [https://www.myetherwallet.com/]. I used the keypair generated by the wallet application. The file generally can be found in `/home/manish/.ethereum/testnet/keystore`  
 `infura` : The Infura url. Infura provides ethereum infrastrucutre to test ethereum based application without actually going through the painful ethreum infrastrucutre set up and synching it with testnets on local machine.    
 `accountto` : The Testnet account where you want you ethers to be sent into.   
    
##  How to Run    
```bash
    $ mvn clean compile package
    $ java  -Dpassword=${YOUR_ACCOUT_PASSWORD} -cp target/eth-web3j-1.0-SNAPSHOT-jar-with-dependencies.jar com.knoldus.eth.TransferDemo
```
