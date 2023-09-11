-- mysql
select t.*, if(x + y > z and x + z > y and y + z > x, "Yes", "No") as triangle
from triangle t;