CREATE TABLE notification."Notification_channel"
(
    id integer NOT NULL,
    name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Notification_channel_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE notification."Notification_channel"
    OWNER to postgres;