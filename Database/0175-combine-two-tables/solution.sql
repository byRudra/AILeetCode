select firstName, lastName, city, state
from person a left join address b on
a.personid = b.personid