--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5 (Ubuntu 11.5-3.pgdg18.04+1)
-- Dumped by pg_dump version 11.5 (Ubuntu 11.5-3.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: academic_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.academic_details (
    academic_id integer NOT NULL,
    academic_name character varying(100),
    start_year smallint,
    end_year smallint,
    description character varying(300),
    user_ref integer NOT NULL
);


ALTER TABLE public.academic_details OWNER TO postgres;

--
-- Name: academic_details_academic_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.academic_details_academic_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.academic_details_academic_id_seq OWNER TO postgres;

--
-- Name: academic_details_academic_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.academic_details_academic_id_seq OWNED BY public.academic_details.academic_id;


--
-- Name: academic_details_user_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.academic_details_user_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.academic_details_user_ref_seq OWNER TO postgres;

--
-- Name: academic_details_user_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.academic_details_user_ref_seq OWNED BY public.academic_details.user_ref;


--
-- Name: assignment_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.assignment_details (
    assignment_id integer NOT NULL,
    assignment_name character varying(50),
    course_ref integer NOT NULL,
    assignment_description character varying(200),
    deadline timestamp without time zone,
    reference_file_ref integer,
    is_deleted boolean,
    created_on timestamp without time zone,
    created_by integer
);


ALTER TABLE public.assignment_details OWNER TO postgres;

--
-- Name: assignment_details_assignment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.assignment_details_assignment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.assignment_details_assignment_id_seq OWNER TO postgres;

--
-- Name: assignment_details_assignment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.assignment_details_assignment_id_seq OWNED BY public.assignment_details.assignment_id;


--
-- Name: assignment_details_course_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.assignment_details_course_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.assignment_details_course_ref_seq OWNER TO postgres;

--
-- Name: assignment_details_course_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.assignment_details_course_ref_seq OWNED BY public.assignment_details.course_ref;


--
-- Name: assignment_details_created_by_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.assignment_details_created_by_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.assignment_details_created_by_seq OWNER TO postgres;

--
-- Name: assignment_details_created_by_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.assignment_details_created_by_seq OWNED BY public.assignment_details.created_by;


--
-- Name: assignment_details_reference_file_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.assignment_details_reference_file_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.assignment_details_reference_file_ref_seq OWNER TO postgres;

--
-- Name: assignment_details_reference_file_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.assignment_details_reference_file_ref_seq OWNED BY public.assignment_details.reference_file_ref;


--
-- Name: course_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_list (
    course_id integer NOT NULL,
    course_name character varying(30),
    course_field character varying(20),
    primary_staff integer NOT NULL
);


ALTER TABLE public.course_list OWNER TO postgres;

--
-- Name: course_list_course_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_list_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.course_list_course_id_seq OWNER TO postgres;

--
-- Name: course_list_course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_list_course_id_seq OWNED BY public.course_list.course_id;


--
-- Name: course_list_primary_staff_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_list_primary_staff_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.course_list_primary_staff_seq OWNER TO postgres;

--
-- Name: course_list_primary_staff_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_list_primary_staff_seq OWNED BY public.course_list.primary_staff;


--
-- Name: course_staff_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_staff_list (
    course_id integer NOT NULL,
    staff_id integer NOT NULL
);


ALTER TABLE public.course_staff_list OWNER TO postgres;

--
-- Name: course_staff_list_course_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_staff_list_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.course_staff_list_course_id_seq OWNER TO postgres;

--
-- Name: course_staff_list_course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_staff_list_course_id_seq OWNED BY public.course_staff_list.course_id;


--
-- Name: course_staff_list_staff_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_staff_list_staff_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.course_staff_list_staff_id_seq OWNER TO postgres;

--
-- Name: course_staff_list_staff_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_staff_list_staff_id_seq OWNED BY public.course_staff_list.staff_id;


--
-- Name: family_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.family_details (
    family_id integer NOT NULL,
    father_name character varying(30),
    father_occupation character varying(30),
    mother_name character varying(30),
    mother_occupation character varying(30)
);


ALTER TABLE public.family_details OWNER TO postgres;

--
-- Name: family_info_family_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.family_info_family_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.family_info_family_id_seq OWNER TO postgres;

--
-- Name: family_info_family_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.family_info_family_id_seq OWNED BY public.family_details.family_id;


--
-- Name: profile_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profile_info (
    profile_id integer NOT NULL,
    user_ref integer NOT NULL,
    about_user character varying(300),
    address_user character varying(200),
    date_of_birth date,
    gender "char",
    hometown character varying(15),
    religion character varying(10),
    profile_picture integer NOT NULL
);


ALTER TABLE public.profile_info OWNER TO postgres;

--
-- Name: profile_info_profile_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profile_info_profile_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profile_info_profile_id_seq OWNER TO postgres;

--
-- Name: profile_info_profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profile_info_profile_id_seq OWNED BY public.profile_info.profile_id;


--
-- Name: profile_info_profile_picture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profile_info_profile_picture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profile_info_profile_picture_seq OWNER TO postgres;

--
-- Name: profile_info_profile_picture_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profile_info_profile_picture_seq OWNED BY public.profile_info.profile_picture;


--
-- Name: profile_info_user_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profile_info_user_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profile_info_user_ref_seq OWNER TO postgres;

--
-- Name: profile_info_user_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profile_info_user_ref_seq OWNED BY public.profile_info.user_ref;


--
-- Name: siblings_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.siblings_details (
    sibling_id integer NOT NULL,
    sibling_name character varying(30),
    sibling_occupation character varying(30),
    family_id integer NOT NULL
);


ALTER TABLE public.siblings_details OWNER TO postgres;

--
-- Name: siblings_details_family_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.siblings_details_family_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.siblings_details_family_id_seq OWNER TO postgres;

--
-- Name: siblings_details_family_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.siblings_details_family_id_seq OWNED BY public.siblings_details.family_id;


--
-- Name: siblings_details_sibling_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.siblings_details_sibling_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.siblings_details_sibling_id_seq OWNER TO postgres;

--
-- Name: siblings_details_sibling_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.siblings_details_sibling_id_seq OWNED BY public.siblings_details.sibling_id;


--
-- Name: staff_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.staff_details (
    staff_id integer NOT NULL,
    staff_name character varying(30),
    field character varying(20),
    technology_known character varying(100)
);


ALTER TABLE public.staff_details OWNER TO postgres;

--
-- Name: staff_details_staff_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.staff_details_staff_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.staff_details_staff_id_seq OWNER TO postgres;

--
-- Name: staff_details_staff_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.staff_details_staff_id_seq OWNED BY public.staff_details.staff_id;


--
-- Name: submission_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.submission_details (
    submission_id integer NOT NULL,
    assignment_ref integer NOT NULL,
    submission_file_ref integer NOT NULL,
    submitted_on timestamp without time zone,
    user_ref integer NOT NULL
);


ALTER TABLE public.submission_details OWNER TO postgres;

--
-- Name: submission_details_assignment_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.submission_details_assignment_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.submission_details_assignment_ref_seq OWNER TO postgres;

--
-- Name: submission_details_assignment_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.submission_details_assignment_ref_seq OWNED BY public.submission_details.assignment_ref;


--
-- Name: submission_details_submission_file_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.submission_details_submission_file_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.submission_details_submission_file_ref_seq OWNER TO postgres;

--
-- Name: submission_details_submission_file_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.submission_details_submission_file_ref_seq OWNED BY public.submission_details.submission_file_ref;


--
-- Name: submission_details_submission_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.submission_details_submission_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.submission_details_submission_id_seq OWNER TO postgres;

--
-- Name: submission_details_submission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.submission_details_submission_id_seq OWNED BY public.submission_details.submission_id;


--
-- Name: submission_details_user_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.submission_details_user_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.submission_details_user_ref_seq OWNER TO postgres;

--
-- Name: submission_details_user_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.submission_details_user_ref_seq OWNED BY public.submission_details.user_ref;


--
-- Name: upload_files; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.upload_files (
    file_id integer NOT NULL,
    file_name character varying(50),
    file_original_name character varying(50),
    uploaded_on timestamp without time zone,
    last_access_on timestamp without time zone,
    is_deleted boolean
);


ALTER TABLE public.upload_files OWNER TO postgres;

--
-- Name: upload_files_file_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.upload_files_file_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.upload_files_file_id_seq OWNER TO postgres;

--
-- Name: upload_files_file_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.upload_files_file_id_seq OWNED BY public.upload_files.file_id;


--
-- Name: user_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_details (
    user_id integer NOT NULL,
    username character varying(30) NOT NULL,
    password character varying(70) NOT NULL,
    email character varying(30) NOT NULL,
    user_uuid character varying(50) NOT NULL,
    created_on timestamp without time zone NOT NULL,
    last_login_on timestamp without time zone,
    is_locked boolean NOT NULL,
    group_ref integer,
    family_ref integer
);


ALTER TABLE public.user_details OWNER TO postgres;

--
-- Name: user_details_family_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_details_family_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_details_family_ref_seq OWNER TO postgres;

--
-- Name: user_details_family_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_details_family_ref_seq OWNED BY public.user_details.family_ref;


--
-- Name: user_details_group_ref_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_details_group_ref_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_details_group_ref_seq OWNER TO postgres;

--
-- Name: user_details_group_ref_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_details_group_ref_seq OWNED BY public.user_details.group_ref;


--
-- Name: user_details_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_details_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_details_user_id_seq OWNER TO postgres;

--
-- Name: user_details_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_details_user_id_seq OWNED BY public.user_details.user_id;


--
-- Name: user_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_group (
    group_id integer NOT NULL,
    group_name character varying(20),
    short_group character varying(5),
    is_active boolean
);


ALTER TABLE public.user_group OWNER TO postgres;

--
-- Name: user_group_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_group_group_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_group_group_id_seq OWNER TO postgres;

--
-- Name: user_group_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_group_group_id_seq OWNED BY public.user_group.group_id;


--
-- Name: academic_details academic_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.academic_details ALTER COLUMN academic_id SET DEFAULT nextval('public.academic_details_academic_id_seq'::regclass);


--
-- Name: academic_details user_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.academic_details ALTER COLUMN user_ref SET DEFAULT nextval('public.academic_details_user_ref_seq'::regclass);


--
-- Name: assignment_details assignment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details ALTER COLUMN assignment_id SET DEFAULT nextval('public.assignment_details_assignment_id_seq'::regclass);


--
-- Name: assignment_details course_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details ALTER COLUMN course_ref SET DEFAULT nextval('public.assignment_details_course_ref_seq'::regclass);


--
-- Name: assignment_details reference_file_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details ALTER COLUMN reference_file_ref SET DEFAULT nextval('public.assignment_details_reference_file_ref_seq'::regclass);


--
-- Name: assignment_details created_by; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details ALTER COLUMN created_by SET DEFAULT nextval('public.assignment_details_created_by_seq'::regclass);


--
-- Name: course_list course_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_list ALTER COLUMN course_id SET DEFAULT nextval('public.course_list_course_id_seq'::regclass);


--
-- Name: course_list primary_staff; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_list ALTER COLUMN primary_staff SET DEFAULT nextval('public.course_list_primary_staff_seq'::regclass);


--
-- Name: course_staff_list course_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_staff_list ALTER COLUMN course_id SET DEFAULT nextval('public.course_staff_list_course_id_seq'::regclass);


--
-- Name: course_staff_list staff_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_staff_list ALTER COLUMN staff_id SET DEFAULT nextval('public.course_staff_list_staff_id_seq'::regclass);


--
-- Name: family_details family_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_details ALTER COLUMN family_id SET DEFAULT nextval('public.family_info_family_id_seq'::regclass);


--
-- Name: profile_info profile_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_info ALTER COLUMN profile_id SET DEFAULT nextval('public.profile_info_profile_id_seq'::regclass);


--
-- Name: profile_info user_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_info ALTER COLUMN user_ref SET DEFAULT nextval('public.profile_info_user_ref_seq'::regclass);


--
-- Name: profile_info profile_picture; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_info ALTER COLUMN profile_picture SET DEFAULT nextval('public.profile_info_profile_picture_seq'::regclass);


--
-- Name: siblings_details sibling_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.siblings_details ALTER COLUMN sibling_id SET DEFAULT nextval('public.siblings_details_sibling_id_seq'::regclass);


--
-- Name: siblings_details family_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.siblings_details ALTER COLUMN family_id SET DEFAULT nextval('public.siblings_details_family_id_seq'::regclass);


--
-- Name: staff_details staff_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff_details ALTER COLUMN staff_id SET DEFAULT nextval('public.staff_details_staff_id_seq'::regclass);


--
-- Name: submission_details submission_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details ALTER COLUMN submission_id SET DEFAULT nextval('public.submission_details_submission_id_seq'::regclass);


--
-- Name: submission_details assignment_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details ALTER COLUMN assignment_ref SET DEFAULT nextval('public.submission_details_assignment_ref_seq'::regclass);


--
-- Name: submission_details submission_file_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details ALTER COLUMN submission_file_ref SET DEFAULT nextval('public.submission_details_submission_file_ref_seq'::regclass);


--
-- Name: submission_details user_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details ALTER COLUMN user_ref SET DEFAULT nextval('public.submission_details_user_ref_seq'::regclass);


--
-- Name: upload_files file_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.upload_files ALTER COLUMN file_id SET DEFAULT nextval('public.upload_files_file_id_seq'::regclass);


--
-- Name: user_details user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details ALTER COLUMN user_id SET DEFAULT nextval('public.user_details_user_id_seq'::regclass);


--
-- Name: user_details group_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details ALTER COLUMN group_ref SET DEFAULT nextval('public.user_details_group_ref_seq'::regclass);


--
-- Name: user_details family_ref; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details ALTER COLUMN family_ref SET DEFAULT nextval('public.user_details_family_ref_seq'::regclass);


--
-- Name: user_group group_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group ALTER COLUMN group_id SET DEFAULT nextval('public.user_group_group_id_seq'::regclass);


--
-- Data for Name: academic_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.academic_details (academic_id, academic_name, start_year, end_year, description, user_ref) FROM stdin;
\.


--
-- Data for Name: assignment_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.assignment_details (assignment_id, assignment_name, course_ref, assignment_description, deadline, reference_file_ref, is_deleted, created_on, created_by) FROM stdin;
2	Sample	30	Sample Desc	2019-11-30 05:30:00	2	f	2019-11-16 12:32:14.884	\N
3	RDBMS	30	Database Mgmt	2019-11-24 05:30:00	3	f	2019-11-16 17:54:29.81	\N
\.


--
-- Data for Name: course_list; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_list (course_id, course_name, course_field, primary_staff) FROM stdin;
30	Java	Computer Science	3
31	Maths	Mathematics	4
32	Algo	Physics	1
33	Physics	Physics	3
\.


--
-- Data for Name: course_staff_list; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_staff_list (course_id, staff_id) FROM stdin;
30	4
30	2
31	2
31	1
32	3
32	5
\.


--
-- Data for Name: family_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.family_details (family_id, father_name, father_occupation, mother_name, mother_occupation) FROM stdin;
\.


--
-- Data for Name: profile_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profile_info (profile_id, user_ref, about_user, address_user, date_of_birth, gender, hometown, religion, profile_picture) FROM stdin;
\.


--
-- Data for Name: siblings_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.siblings_details (sibling_id, sibling_name, sibling_occupation, family_id) FROM stdin;
\.


--
-- Data for Name: staff_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.staff_details (staff_id, staff_name, field, technology_known) FROM stdin;
3	Richard Mark	Chemistry	Molecular Theory
4	George Boole	Computer Science	C, C++, Assembly
5	Aryabhata	Mathematics	Algebra, Trignometry
2	John Abhraham Li	Botony	Florist
1	Kennedy Shaw	Computer Science	Java, SQL, C, .NET
\.


--
-- Data for Name: submission_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.submission_details (submission_id, assignment_ref, submission_file_ref, submitted_on, user_ref) FROM stdin;
\.


--
-- Data for Name: upload_files; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.upload_files (file_id, file_name, file_original_name, uploaded_on, last_access_on, is_deleted) FROM stdin;
1	1573887676602_spec.yaml	spec.yaml	2019-11-16 12:31:16.658	\N	f
2	1573887734884_spec.yaml	spec.yaml	2019-11-16 12:32:14.884	\N	f
3	1573907069810_Db.zip	Db.zip	2019-11-16 17:54:29.862	\N	f
\.


--
-- Data for Name: user_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_details (user_id, username, password, email, user_uuid, created_on, last_login_on, is_locked, group_ref, family_ref) FROM stdin;
1	Admin	$2a$10$aD1pF5ELLrAWBoXRyY1rIOeGew2HEpXrCqG5JbAT0lPSQg9kuDf7G	admin@spring.ats	a017f47c-f75a-3d39-a3a4-ac2ba9d9f215	2019-11-10 18:50:47.805134	\N	f	1	\N
6	Peter	$2a$10$JcwAI26zxj3lFYMcPMhVC.8C2fF5fdPYIw6BH8aKUuKJ4FjEabB8u	peter@ats.com	e9f6cb22-8227-32f9-8ae7-a083769c901c	2019-11-12 23:21:53.47	\N	f	3	\N
7	Tony	$2a$10$X3Y9/UDeC4zakr5PTKeeOefVGhLE5rzFDMC8lvLTkbtx4kiN9KFEi	tony@ats.com	294c6ae3-b420-3e8e-a5f4-940fc98fa545	2019-11-12 23:21:53.47	\N	f	2	\N
8	Manu	$2a$10$xlqWB3RUlvkbnHA9mZuB/e7Ib50tgstkhrGGwf1CyQEJxKkWaT0Uq	manu@ats.com	2fe2c5ec-6d75-30e8-8182-ac9166604fa6	2019-11-12 23:21:53.47	\N	f	3	\N
9	Max	$2a$10$yEd8/l9rFAqi2GkQhweUge7bKzU1oezWdUoWEKEWQZx0F7eCUIjpG	max@ats.com	29e05aa6-1c02-32cb-be3c-04202a8e39d4	2019-11-12 23:21:53.47	\N	f	3	\N
3	John	$2a$10$AiK2zW/I8xUWtvhncK5DsOUhNJBrGY0ZVeW9oplHkGpEIljfXjd6m	john@ats.com	daee4ea2-9858-394d-9471-f47b2efe8b97	2019-11-12 23:18:24.857	\N	f	2	\N
10	Victoria	$2a$10$dvHFajzzmWAkyEh/2PhXGe.CkURfskESeVkIoU6yDb9O5noAHprRy	victoria@ats.com	afde068f-294a-3acf-aa7c-2ad748ebc893	2019-11-13 19:28:51.111	\N	f	4	\N
11	Ana	$2a$10$/thRUKGx4vldgwz.xEeJxu7WorXxAnbsRcy9eR63KTbKI9GZ8BbF6	ana@ats.com	b010404a-7cd1-3899-80e9-ff00ca7d3a20	2019-11-13 19:28:51.111	\N	f	5	\N
12	Alexia	$2a$10$vHpq2TuafqgdTHMJWopeIO.MRGfRBNFSyiAl5OrozftvOjKKz7tD6	alexia@ats.com	38531cf2-8048-3ae4-8df2-d859ae679b9f	2019-11-13 19:28:51.111	\N	f	3	\N
13	Samuel	$2a$10$9m58NEoY0CdHJZsVpgsIpOH.SpJJJSS5HmXMorUah7G.u03uWD6kW	samuel@ats.com	ffa0dbbc-f2ee-3843-9397-d2264b7c3ba1	2019-11-13 19:28:51.111	\N	f	2	\N
14	Jerry	$2a$10$r9afWb7YykxnERzD5rcYAeAbrAvc8Qm0hjucpHgzMOYFtxbOYt2fu	jerry@ats.com	e3a633a1-6c5f-3ded-ab52-c291b4a66d11	2019-11-13 19:28:51.111	\N	f	4	\N
15	Fred	$2a$10$D40mZyOOT6E6ibjoAcQb2OzUB6pUAA4jLc32jpU2QBjOccn7T84TG	fred@ats.com	1402843f-fedc-3101-89ca-d024bef35ea0	2019-11-13 19:28:51.111	\N	f	5	\N
16	Henry	$2a$10$71UVmiACjkOibtfkpAECve2WJD/ObSik3eVKTDdfIwE17D94BJLEi	henry@ats.com	004fb221-e94b-3908-830f-a28b205d6cfb	2019-11-13 19:28:51.111	\N	f	6	\N
17	Louis	$2a$10$WNp8VXyLHXs5sVIcGgWFjuBAqWhubiQq4DILbtBZTzy1.w5ggGb.u	louis@ats.com	f4d34d13-5c03-36e7-b8ff-9475eb896fc7	2019-11-13 19:28:51.111	\N	f	4	\N
18	Charles	$2a$10$UWdoPh30W3Pl044cD81oCO1ZevaLZWURTHEO/Ay1erjJ68O.1hg8u	charles@ats.com	1ec88f45-936d-3d1a-bc9a-7ed3ec8d2f05	2019-11-13 19:28:51.111	\N	f	6	\N
19	James	$2a$10$BsclxTVzuDR.FAsGzygf9ONPMmpVu4.SQ99kbIlZy8MrXLU4lLXLu	james@ats.com	055e5653-7db6-300d-b048-e898ec84c799	2019-11-13 19:28:51.111	\N	f	4	\N
2	George	$2a$10$ENAad3dXM9eb792dWpO8/uNfM2M1suowUAU2uvUDlzUxe5UwPo/Mq	george@ats.com	fd4d91d8-4dc0-3c3d-8043-ea69ef7a19a1	2019-11-12 23:18:24.857	\N	f	2	\N
4	Steve	$2a$10$/Q9Sk3SJwi98l2qpOYwcjuXYUJqkyEtgWu8m9umjpS1.0zzw0pNO.	steve@ats.com	c5198f4d-bf7d-374f-ad00-fd6883979539	2019-11-12 23:18:24.857	\N	f	2	\N
5	Stark	$2a$10$lcpQ6v4JVNWSFg.uYiLr0eKWNMaoBw1qgpQa/Ddtq2.SAeus2YdXe	stark@ats.com	68825a9c-27bd-34b3-8f4c-9ea1e796f5bc	2019-11-12 23:18:24.857	\N	f	2	\N
20	Jessica	$2a$10$CuXt4FEismQGZeFNW9m6OeYDbYKw4n8UPYgGrT5acJgdRKeDfZvsC	jessica@ats.com	645551ba-e12c-3b6a-9f77-2cf8a2b34638	2019-11-14 19:57:04.373	\N	f	5	\N
21	Sergey	$2a$10$Wtqf7k.pFaj7bI4dltVsaeOGBwMiP.PoGBypvukWRtBCedke9J3aq	sergey@ats.com	750a486c-ec5b-348c-a576-6c6cbce62187	2019-11-14 19:59:40.055	\N	f	6	\N
\.


--
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_group (group_id, group_name, short_group, is_active) FROM stdin;
1	ADMIN	AD	t
2	Batch B3 - 2019/II	B3	t
3	Batch C3 - 2018/I	C3	t
4	Batch A3 - 2019/I	A3	t
5	Batch A4 - 2018/II	A4	t
6	Batch C2 - 2018/II	C2	t
\.


--
-- Name: academic_details_academic_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.academic_details_academic_id_seq', 1, false);


--
-- Name: academic_details_user_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.academic_details_user_ref_seq', 1, false);


--
-- Name: assignment_details_assignment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.assignment_details_assignment_id_seq', 3, true);


--
-- Name: assignment_details_course_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.assignment_details_course_ref_seq', 1, false);


--
-- Name: assignment_details_created_by_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.assignment_details_created_by_seq', 1, false);


--
-- Name: assignment_details_reference_file_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.assignment_details_reference_file_ref_seq', 1, false);


--
-- Name: course_list_course_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_list_course_id_seq', 33, true);


--
-- Name: course_list_primary_staff_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_list_primary_staff_seq', 1, false);


--
-- Name: course_staff_list_course_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_staff_list_course_id_seq', 1, false);


--
-- Name: course_staff_list_staff_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_staff_list_staff_id_seq', 1, false);


--
-- Name: family_info_family_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.family_info_family_id_seq', 1, false);


--
-- Name: profile_info_profile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profile_info_profile_id_seq', 1, false);


--
-- Name: profile_info_profile_picture_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profile_info_profile_picture_seq', 1, false);


--
-- Name: profile_info_user_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profile_info_user_ref_seq', 1, false);


--
-- Name: siblings_details_family_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.siblings_details_family_id_seq', 1, false);


--
-- Name: siblings_details_sibling_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.siblings_details_sibling_id_seq', 1, false);


--
-- Name: staff_details_staff_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.staff_details_staff_id_seq', 5, true);


--
-- Name: submission_details_assignment_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.submission_details_assignment_ref_seq', 1, false);


--
-- Name: submission_details_submission_file_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.submission_details_submission_file_ref_seq', 1, false);


--
-- Name: submission_details_submission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.submission_details_submission_id_seq', 1, false);


--
-- Name: submission_details_user_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.submission_details_user_ref_seq', 1, false);


--
-- Name: upload_files_file_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.upload_files_file_id_seq', 3, true);


--
-- Name: user_details_family_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_details_family_ref_seq', 10, true);


--
-- Name: user_details_group_ref_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_details_group_ref_seq', 8, true);


--
-- Name: user_details_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_details_user_id_seq', 21, true);


--
-- Name: user_group_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_group_group_id_seq', 1, false);


--
-- Name: academic_details academic_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.academic_details
    ADD CONSTRAINT academic_details_pkey PRIMARY KEY (academic_id);


--
-- Name: assignment_details assignment_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details
    ADD CONSTRAINT assignment_details_pkey PRIMARY KEY (assignment_id);


--
-- Name: course_list course_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_list
    ADD CONSTRAINT course_list_pkey PRIMARY KEY (course_id);


--
-- Name: course_staff_list course_staff_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_staff_list
    ADD CONSTRAINT course_staff_list_pkey PRIMARY KEY (course_id, staff_id);


--
-- Name: course_staff_list course_staff_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_staff_list
    ADD CONSTRAINT course_staff_unique UNIQUE (course_id, staff_id);


--
-- Name: family_details family_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.family_details
    ADD CONSTRAINT family_info_pkey PRIMARY KEY (family_id);


--
-- Name: profile_info profile_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_info
    ADD CONSTRAINT profile_info_pkey PRIMARY KEY (profile_id);


--
-- Name: siblings_details siblings_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.siblings_details
    ADD CONSTRAINT siblings_details_pkey PRIMARY KEY (sibling_id);


--
-- Name: staff_details staff_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff_details
    ADD CONSTRAINT staff_details_pkey PRIMARY KEY (staff_id);


--
-- Name: submission_details submission_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details
    ADD CONSTRAINT submission_details_pkey PRIMARY KEY (submission_id);


--
-- Name: upload_files upload_files_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.upload_files
    ADD CONSTRAINT upload_files_pkey PRIMARY KEY (file_id);


--
-- Name: user_details user_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_details_pkey PRIMARY KEY (user_id);


--
-- Name: user_details user_family_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_family_unique UNIQUE (family_ref);


--
-- Name: user_group user_group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group
    ADD CONSTRAINT user_group_pkey PRIMARY KEY (group_id);


--
-- Name: user_details user_uuid_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_uuid_unique UNIQUE (user_uuid);


--
-- Name: academic_details academic_user_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.academic_details
    ADD CONSTRAINT academic_user_ref FOREIGN KEY (user_ref) REFERENCES public.user_details(user_id) NOT VALID;


--
-- Name: assignment_details assignment_course_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details
    ADD CONSTRAINT assignment_course_ref FOREIGN KEY (course_ref) REFERENCES public.course_list(course_id);


--
-- Name: assignment_details assignment_file_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details
    ADD CONSTRAINT assignment_file_ref FOREIGN KEY (reference_file_ref) REFERENCES public.upload_files(file_id);


--
-- Name: assignment_details assignment_user_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment_details
    ADD CONSTRAINT assignment_user_ref FOREIGN KEY (created_by) REFERENCES public.user_details(user_id) NOT VALID;


--
-- Name: course_list course_staff_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_list
    ADD CONSTRAINT course_staff_ref FOREIGN KEY (primary_staff) REFERENCES public.staff_details(staff_id);


--
-- Name: course_staff_list list_course_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_staff_list
    ADD CONSTRAINT list_course_ref FOREIGN KEY (course_id) REFERENCES public.course_list(course_id);


--
-- Name: course_staff_list list_staff_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_staff_list
    ADD CONSTRAINT list_staff_ref FOREIGN KEY (staff_id) REFERENCES public.staff_details(staff_id);


--
-- Name: profile_info profile_file_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_info
    ADD CONSTRAINT profile_file_ref FOREIGN KEY (profile_picture) REFERENCES public.upload_files(file_id) NOT VALID;


--
-- Name: profile_info profile_user_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_info
    ADD CONSTRAINT profile_user_ref FOREIGN KEY (user_ref) REFERENCES public.user_details(user_id);


--
-- Name: siblings_details siblings_family_reference; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.siblings_details
    ADD CONSTRAINT siblings_family_reference FOREIGN KEY (family_id) REFERENCES public.family_details(family_id) NOT VALID;


--
-- Name: submission_details submission_assignment_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details
    ADD CONSTRAINT submission_assignment_ref FOREIGN KEY (assignment_ref) REFERENCES public.assignment_details(assignment_id);


--
-- Name: submission_details submission_file_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details
    ADD CONSTRAINT submission_file_ref FOREIGN KEY (submission_file_ref) REFERENCES public.upload_files(file_id);


--
-- Name: submission_details submission_user_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.submission_details
    ADD CONSTRAINT submission_user_ref FOREIGN KEY (user_ref) REFERENCES public.user_details(user_id);


--
-- Name: user_details user_family_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_family_ref FOREIGN KEY (family_ref) REFERENCES public.family_details(family_id);


--
-- Name: user_details user_group_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_group_ref FOREIGN KEY (group_ref) REFERENCES public.user_group(group_id);


--
-- PostgreSQL database dump complete
--

