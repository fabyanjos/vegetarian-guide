ALTER TABLE restaurants ADD CONSTRAINT UQ_RESTAURANTS_NAME UNIQUE (name);
ALTER TABLE restaurants ADD COLUMN delivery character varying(1) NOT NULL DEFAULT 'N';
ALTER TABLE restaurants ADD COLUMN openingtimes character varying(255);
ALTER TABLE restaurants ADD COLUMN price integer DEFAULT 0;
