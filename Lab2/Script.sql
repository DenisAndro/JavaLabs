-- Table: public.project

-- DROP TABLE IF EXISTS public.project;

CREATE TABLE IF NOT EXISTS public.project
(
    id uuid NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    startdate text COLLATE pg_catalog."default" NOT NULL,
    enddate text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Project_pkey" PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.project
    OWNER to postgres;

-- Table: public.task

-- DROP TABLE IF EXISTS public.task;

CREATE TABLE IF NOT EXISTS public.task
(
    id uuid NOT NULL,
    title text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    status text COLLATE pg_catalog."default" NOT NULL DEFAULT 'New'::text,
    projectid uuid NOT NULL,
    CONSTRAINT "Task_pkey" PRIMARY KEY (id),
    CONSTRAINT "projectId" FOREIGN KEY (projectid)
    REFERENCES public.project (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.task
    OWNER to postgres;