package me.study.unittest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

// Example 6.14
public class ApplicationService {

    private final String directoryName;
    private final AuditManager_V3 auditManager;
    private final Persister persister;

    public ApplicationService(String directoryName, int maxEntriesPerFile) {
        this.directoryName = directoryName;
        this.auditManager = new AuditManager_V3(maxEntriesPerFile);
        this.persister = new Persister();
    }

    public void addRecord(String visitorName, LocalDateTime timeOfVisit) throws IOException {
        final List<FileContent> files = persister.readDirectory(directoryName);
        final FileUpdate update = auditManager.addRecord(files, visitorName, timeOfVisit);
        persister.applyUpdate(directoryName, update);
    }
}
