package org.guajavita;

import static org.bytedeco.llvm.global.LLVM.LLVMGetVersion;

public class Main {

    public static void main(String[] args) {
        int[] major = {0};
        int[] minor = {0};
        int[] patch = {0};
        LLVMGetVersion(major,minor,patch);
        System.out.printf("OK %s.%s.%s \n", major[0],minor[0],patch[0]);
    }
}
