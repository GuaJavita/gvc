package org.guajavita;

public interface Version {

    String GIT = "${git.commit.id.abbrev}";
    String JCV = "${project.version}";
    String PLAT = "${javacpp.platform}";
    String FULL = "gvc ${project.version}-${git.commit.id.abbrev}, " +
            "build on: ${git.build.time} llvm version: ${llvm} host ${javacpp.platform}";

}
