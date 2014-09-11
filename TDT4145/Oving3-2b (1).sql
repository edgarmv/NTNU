CREATE TABLE BESTILLING (
    [...]
    FOREIGN KEY (ARTNR) REFERENCES ARTIKKEL(ARTNR)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (KUNDENR) REFERENCES KUNDE(KUNDENR)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE KUNDE (
    [...]
    FOREIGN KEY (POSTNR) REFERENCES POSTSTED(POSTNR)
        ON UPDATE CASCADE
);
