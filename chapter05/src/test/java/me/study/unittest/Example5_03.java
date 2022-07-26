package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Example5_03 {

    @Mock
    IDatabase stub;

    @Test
    void Creating_a_report() throws Exception {
        // Given
        given(stub.getNumberOfUsers()).willReturn(10);
        final Controller sut = new Controller(stub);

        // When
        final Report report = sut.createReport();

        // Then
        assertThat(report.getNumberOfUsers()).isEqualTo(10);
        then(stub).should(only()).getNumberOfUsers(); // over-specification
    }
}
