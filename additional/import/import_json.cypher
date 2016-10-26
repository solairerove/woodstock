WITH {json} as data
UNWIND data.items as q
MERGE (category:Category {id:q.category.id}) ON CREATE
    SET category.name = q.category.name

