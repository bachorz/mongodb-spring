db.createUser(
    {
        user: "bachorz",
        pwd: "bachorz",
        roles: [
            {
                role: "readWrite",
                db: "bachorzdb"
            }
        ]
    }
)
