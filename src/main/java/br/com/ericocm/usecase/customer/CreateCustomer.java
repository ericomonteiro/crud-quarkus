package br.com.ericocm.usecase.customer;

import br.com.ericocm.domain.entity.Customer;
import br.com.ericocm.shared.model.ErrorModel;
import br.com.ericocm.shared.model.ProcessResult;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class CreateCustomer {

    @Transactional()
    public ProcessResult<Customer> execute(Customer customer) {

        try {
            customer.persistAndFlush();
            return ProcessResult.<Customer>builder()
                    .success(true)
                    .object(customer)
                    .build();
        } catch (ConstraintViolationException e) {
            return buildResultError(customer, ErrorModel.fromConstraintViolationException("Error creating customer", e));
        } catch (Exception e) {
            return buildResultError(customer, e.getMessage());
        }

    }

    private ProcessResult<Customer> buildResultError(Customer customer, String message) {
        var error = ErrorModel.builder()
                .title("Error creating customer")
                .message(message)
                .build();

        return buildResultError(customer, Collections.singletonList(error));
    }

    private ProcessResult<Customer> buildResultError(Customer customer, List<ErrorModel> errors) {
        return ProcessResult.<Customer>builder()
                .success(false)
                .errors(errors)
                .object(customer)
                .build();
    }

}
