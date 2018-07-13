package engine;


public @interface User {

    String[] value() default { "ok" };

}
