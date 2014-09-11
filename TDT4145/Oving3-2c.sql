CREATE ASSERTION MAKS_BESTILL CHECK (
    NOT EXISTS (
        SELECT KUNDE.KUNDENR, KUNDE.KREDRITTGRENSE,
               SUM(BESTILLING.KVANTUM * ARTIKKEL.PRIS) AS SUM
        FROM KUNDE, BESTILLING, ARTIKKEL
        WHERE KUNDE.KUNDENR = BESTILLING.KUNDENR
              AND BESTILLING.ARTNR = ARTIKKEL.ARTNR
        GROUP BY KUNDE.KUNDENR, KUNDE.KREDITTGRENSE
        HAVING SUM > KUNDE.KREDITTKRENSE
    )
);
