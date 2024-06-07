package org.example.demodanya.try2.models;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

public record Authors(int id, String name, String biography, Date birthDate) {}
