package br.com.ericocm.shared.model;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class ProcessResult<T> {

    private final T object;
    @Singular
    public final List<ErrorModel> errors;
    public final Boolean success;

    public T get() {
        return this.object;
    }

}
