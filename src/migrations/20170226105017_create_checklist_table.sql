CREATE TABLE checklists(
  id  int(11) DEFAULT NULL auto_increment PRIMARY KEY,
  checklist_type VARCHAR(128),
  content TEXT,
  person_id  int(11),
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;