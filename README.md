##ethweb3j  
A Java Application which connects to go-ethereum client.

##Pre-Requisites
go-ethereum built on your linux machine. If you've not built yet, please refer this very useful blog by `CyberMiles`[https://medium.com/cybermiles/running-a-quick-ethereum-private-network-for-experimentation-and-testing-6b1c23605bce] to see how to set up a quick private ethereum network.  

##How to Run (If you've Ansible Installed)  
Edit go-ethereum related parameters in `ethereum-setup.yml` according to your system settings and run the following commands in two separate windows to observe output.

Window 1
```bash
$ ansible-playbook -v ethereum-setup.yml
```

Window 2
```bash
$ ansible-playbook -v run-ether-client.yml
```
You will see some text like "The deploy go-ethereum client version is:::: Geth/v1.8.14-unstable-76301ca0/linux-amd64/go1.9.3" after running the second command.

##How to Run (Without Ansible)

Initialize the blockchain on your local machine  

```bash
    $ geth --datadir {{data_dir}} init {{data_dir}}/genesis.json
```
Starting Ethereum
```bash
    $ geth --datadir {{data_dir}} --networkid 15 --rpc
```