import React, { useState, useEffect } from "react";

function UserList() {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((res) => {
        if (!res.ok) {
          throw new Error("Failed to fetch users");
        }
        return res.json();
      })
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading users...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div>
      <h2>Users API Data</h2>

      {users.map((user) => (
        <div key={user.id} style={{border:"1px solid gray", padding:"10px", margin:"10px"}}>
          
          <p><b>ID:</b> {user.id}</p>
          <p><b>Name:</b> {user.name}</p>
          <p><b>Username:</b> {user.username}</p>
          <p><b>Email:</b> {user.email}</p>
          <p><b>Phone:</b> {user.phone}</p>
          <p><b>Website:</b> {user.website}</p>

          <h4>Address</h4>
          <p><b>Street:</b> {user.address.street}</p>
          <p><b>Suite:</b> {user.address.suite}</p>
          <p><b>City:</b> {user.address.city}</p>
          <p><b>Zipcode:</b> {user.address.zipcode}</p>

          <h4>Company</h4>
          <p><b>Company Name:</b> {user.company.name}</p>
          <p><b>Catch Phrase:</b> {user.company.catchPhrase}</p>
          <p><b>Business:</b> {user.company.bs}</p>

        </div>
      ))}

    </div>
  );
}

export default UserList;