#MVP

Highest level of organization is a tenant.

A tenant can have multiple users. Users can have different roles but for the mvp all users will have full rights.

A tenant can have multiple namespaces. (up to 10 for mvp) Think of namespace as environments such as test, prod qualif.

A namespace can have multiple applications ( up to 25 for mvp)


A user can create a new config file.

Config files have key - value formats.

A config file can belong to one or all namespaces ( can only be created on all namespace for the mvp)

Inside the namespace, a config file can belong to one or more applications. (can only belong to all application for the mvp)

An endpoint is provided that can export the configuration in various formats.

/namespace/application/config-file-name?format=<format-type>

Only 2 format types will be available for mvp: (json and .properties)

---

Once a config file is created, new values can be added.

A value is always added to all the config files. (in all tenants and applications)

On "add new value" a screen will be available where you can set different values for each occurrence and a default value. (by default, empty string)

On the "edit value" screen, you can choose to edit a value for an occurrence or for all occurrences.

For each, edit, a confirmation screen will appear with the changes.

You can also delete a value (for MVP, deletion can only be done for all occurrences).

---

All actions will be tracked, in the database for audit.
No screen will be developed for MVP

---
Authentication will be done via JWT token. A user can only belong to a single tenant. A user can only download files that belong to it's tenant.

---

A import function will be provided, to provision data. Only .properties format for the MVP.

Import flow: create config file, choose namespace and applications. Provision via import.
