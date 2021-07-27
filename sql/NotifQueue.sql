CREATE TABLE notification."Notification_queue"
(
    id integer NOT NULL,
    n_status integer NOT NULL,
    sender character varying(200) COLLATE pg_catalog."default" NOT NULL,
    receiver character varying(200) COLLATE pg_catalog."default" NOT NULL,
    body character varying(4000) COLLATE pg_catalog."default" NOT NULL,
    subject character varying(200) COLLATE pg_catalog."default",
    insert_date timestamp with time zone NOT NULL,
    process_date timestamp with time zone,
    log_data character varying(200) COLLATE pg_catalog."default",
    notif_channel_id integer NOT NULL,
    CONSTRAINT "Notification_queue_pkey" PRIMARY KEY (id),
    CONSTRAINT "Notification_channel" FOREIGN KEY (notif_channel_id)
        REFERENCES notification."Notification_channel" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Notification_status" FOREIGN KEY (n_status)
        REFERENCES notification."Notification_status" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE notification."Notification_queue"
    OWNER to postgres;