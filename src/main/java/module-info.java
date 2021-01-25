module cs2263.main {
    requires javafx.controls;
    requires com.google.common;
    requires com.google.gson;
    exports edu.isu.cs.cs2263.javafx;
    exports edu.isu.cs.cs2263.serialization;
    exports edu.isu.cs.cs2263.gson;
    opens edu.isu.cs.cs2263.gson to com.google.gson;
}