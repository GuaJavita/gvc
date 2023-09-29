package org.guajavita.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Context {

    private final Map<String, String> functionTable ;

    private final List<String> imports;

    private static final Context context = new Context();
    private Context() {
        imports = new ArrayList<>();
        functionTable = new ConcurrentHashMap<>();
    }

    public static Context get() {
        return context;
    }

    public void addFunction(String key, String value) {
         functionTable.put(key, value);
    }

    public void addImport(String s) {
        imports.add(s);
    }


}
