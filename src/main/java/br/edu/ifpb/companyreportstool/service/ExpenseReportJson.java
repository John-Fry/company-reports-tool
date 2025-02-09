package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExpenseReportJson extends ExpenseReport {

    public ExpenseReportJson(ExpenseRepository expenseRepository) {
        super(expenseRepository);
    }

    public ReportExporter getExporter() {
        return new JsonExporter();
    }

    public String writeBody() {
        return getExporter().exportBody("This is the Expense Report", fillBody() );
    }

    public String fillBody() {
        return super.expenseRepository.findAll().stream()
                .map(Objects::toString).collect(Collectors.joining(","));
    }
}

