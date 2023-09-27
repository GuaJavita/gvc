# GuaJavita Compiler & Tools

## Build Requirements

1. Make
2. Java 17 (soon to be move to 21)

## Build From Source

1. Clone this project
```shell
git clone https://github.com/GuaJavita/jvc.git
```
2. Run the `llvm.sh` or `llvm.ps1` scripts to download the llvm project  **This might take time**
    1.  You might need to enable powershell script execution in Windows
2. Create a build directory
```shell
make 
```
3. Execute
```shell
cd build
```
4. Execute
```shell
   cmake ../
```
5. Execute
```shell
ninja
```

**Note**
