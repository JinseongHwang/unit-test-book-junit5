package me.study.unittest;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Example6_11 {

    @Test
    void A_new_file_is_created_when_the_current_file_overflows() throws Exception {
        // Given
        final String directoryName = "audits";
        final IFileSystem fileSystemMock = mock(IFileSystem.class);
        given(fileSystemMock.getFiles(directoryName)).willReturn(
            List.of("audits/audit_1.txt", "audits/audit_2.txt")
        );
        given(fileSystemMock.readAllLines("audits/audit_2.txt")).willReturn(
            List.of("Peter; 2019-04-06T16:30:00", "Jane; 2019-04-06T16:40:00", "Jack; 2019-04-06T17:00:00")
        );
        final AuditManager_V2 sut = new AuditManager_V2(3, directoryName, fileSystemMock);

        // When
        sut.addRecord("Alice", LocalDateTime.parse("2019-04-06T18:00:00"));

        // Then
        then(fileSystemMock).should().writeAllText("audits/audit_3.txt", "Alice;2019-04-06T18:00:00");
    }
}
