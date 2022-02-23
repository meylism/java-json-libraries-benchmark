package com.meylism.support;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum BenchSupport {
    INTEGERS(
            new LibApi(Library.GSON, Api.DATABIND),
            new LibApi(Library.JACKSON, Api.DATABIND),
            new LibApi(Library.JACKSON_AFTERBURNER, Api.DATABIND),
            new LibApi(Library.DSLJSON, Api.DATABIND),
            new LibApi(Library.DSLJSON_REFLECTION, Api.DATABIND)
    ),
    FLOATS(
            new LibApi(Library.GSON, Api.DATABIND),
            new LibApi(Library.JACKSON, Api.DATABIND),
            new LibApi(Library.JACKSON_AFTERBURNER, Api.DATABIND),
            new LibApi(Library.DSLJSON, Api.DATABIND),
            new LibApi(Library.DSLJSON_REFLECTION, Api.DATABIND)
    ),
    STRINGS(
            new LibApi(Library.GSON, Api.DATABIND),
            new LibApi(Library.JACKSON, Api.DATABIND),
            new LibApi(Library.JACKSON_AFTERBURNER, Api.DATABIND),
            new LibApi(Library.DSLJSON, Api.DATABIND),
            new LibApi(Library.DSLJSON_REFLECTION, Api.DATABIND)
    ),
    NON_ASCII_STRINGS(
            new LibApi(Library.GSON, Api.DATABIND),
            new LibApi(Library.JACKSON, Api.DATABIND),
            new LibApi(Library.JACKSON_AFTERBURNER, Api.DATABIND),
            new LibApi(Library.DSLJSON, Api.DATABIND),
            new LibApi(Library.DSLJSON_REFLECTION, Api.DATABIND)
    ),
    BOOLEANS(
            new LibApi(Library.GSON, Api.DATABIND),
            new LibApi(Library.JACKSON, Api.DATABIND),
            new LibApi(Library.JACKSON_AFTERBURNER, Api.DATABIND),
            new LibApi(Library.DSLJSON, Api.DATABIND),
            new LibApi(Library.DSLJSON_REFLECTION, Api.DATABIND)
    );

    private final List<LibApi> LibApis;

    BenchSupport(LibApi... LibApis) {
        this.LibApis = Arrays.asList(LibApis);
    }

    public List<LibApi> libapis() {
        return LibApis;
    }

    public Set<Library> supportedLibs() {
        return LibApis.stream()
                .filter(LibApi::active)
                .map(LibApi::lib)
                .collect(Collectors.toSet());
    }
}
