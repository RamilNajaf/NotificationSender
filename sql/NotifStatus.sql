CREATE TABLE notification."Notification_status"
(
    id integer NOT NULL,
    name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Notification_status_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE notification."Notification_status"
    OWNER to postgres;