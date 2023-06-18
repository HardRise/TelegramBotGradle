package org.morozov.server;

import org.springframework.stereotype.Service;

@Service
public class FileService {
    private final DocumentEntityDAO documentEntityDAO;
    private final PhotoEntityDAO photoEntityDAO;
    private final AudioEntityDAO audioEntityDAO;

    public FileService(DocumentEntityDAO documentEntityDAO, PhotoEntityDAO photoEntityDAO, AudioEntityDAO audioEntityDAO) {
        this.documentEntityDAO = documentEntityDAO;
        this.photoEntityDAO = photoEntityDAO;
        this.audioEntityDAO = audioEntityDAO;
    }

    public DocumentEntityDAO getDocument(String documentId) {
        var id = Long.parseLong(documentId);
        return documentEntityDAO.findById(id).orElse(null);
    }

    public PhotoEntityDAO getPhoto(String photoId) {
        var id = Long.parseLong(photoId);
        return documentEntityDAO.findById(id).orElse(null);
    }

    public AudioEntityDAO getAudio(String audioId) {
        var id = Long.parseLong(audioId);
        return documentEntityDAO.findById(id).orElse(null);
    }
}
