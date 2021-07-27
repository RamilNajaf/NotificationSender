CREATE SEQUENCE notification.queue
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 10;

ALTER SEQUENCE notification.queue
    OWNER TO postgres;