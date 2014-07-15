ALTER TABLE restaurants ADD CONSTRAINT UQ_RESTAURANTS_NAME UNIQUE (name);
ALTER TABLE restaurants ADD COLUMN delivery character varying(6) NOT NULL DEFAULT 'no';
