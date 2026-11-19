CREATE TABLE ownership_confirmations (
    id BIGINT NOT NULL AUTO_INCREMENT,
    request_id BIGINT NOT NULL,
    professional_id BIGINT NOT NULL,
    notes VARCHAR(255),
    confirmed_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uq_ownership_request UNIQUE (request_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE service_reports (
    id BIGINT NOT NULL AUTO_INCREMENT,
    request_id BIGINT NOT NULL,
    professional_id BIGINT NOT NULL,
    cycle INT NOT NULL,
    work_done VARCHAR(1000) NOT NULL,
    materials VARCHAR(500),
    final_value DOUBLE NOT NULL,
    warranty_days INT NOT NULL,
    created_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uq_report_request_cycle UNIQUE (request_id, cycle),
    CONSTRAINT ck_report_warranty_days CHECK (warranty_days BETWEEN 0 AND 365)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
