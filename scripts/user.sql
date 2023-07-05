-- User
CREATE USER tienda_electronica_usb WITH ENCRYPTED PASSWORD 'TIENDA_ELECTRONICA_USB';
CREATE DATABASE tienda_app WITH OWNER tienda_electronica_usb;

-- Schema
CREATE SCHEMA IF NOT EXISTS multi_nivel AUTHORIZATION tienda_electronica_usb;
