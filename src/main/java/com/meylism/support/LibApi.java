package com.meylism.support;

import java.util.Arrays;
import java.util.List;

public class LibApi {

    private final boolean active;
    private final Library lib;
    private final List<Api> api;

    public LibApi(Library lib, Api... api) {
        this(true, lib, api);
    }

    public LibApi(boolean active, Library lib, Api... api) {
        this.active = active;
        this.lib = lib;
        this.api = Arrays.asList(api);
    }

    public boolean active() {
        return active;
    }

    public Library lib() {
        return lib;
    }

    public List<Api> api() {
        return api;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibApi)) return false;

        LibApi libapi = (LibApi) o;

        if (lib != libapi.lib) return false;
        return api == libapi.api;

    }

    @Override
    public int hashCode() {
        int result = lib != null ? lib.hashCode() : 0;
        result = 31 * result + (api != null ? api.hashCode() : 0);
        return result;
    }
}

