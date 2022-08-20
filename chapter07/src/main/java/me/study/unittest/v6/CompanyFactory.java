package me.study.unittest.v6;

public class CompanyFactory {

    public static Company create(Object[] data) throws Exception {
        Precondition.requires(data.length >= 2);

        final String domainName = (String)data[0];
        final int numberOfEmployees = (int)data[1];

        return new Company(domainName, numberOfEmployees);
    }
}
