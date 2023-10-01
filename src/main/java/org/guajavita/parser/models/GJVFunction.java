package org.guajavita.parser.models;

import java.util.List;

public record GJVFunction(String returnType, String name, List<GJVFunctionParam> params, String body) {


}
