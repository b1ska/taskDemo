import React, { useState } from "react";
import ReactDOM from "react-dom";

import "./styles.css";

function App() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);

    const database = [
        {
            username: "user1",
            password: "pass1"
        },
        {
            username: "user2",
            password: "pass2"
        }
    ];

    const errors = {
        uname: "Invalid username",
        pass: "Invalid password"
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        const userData = database.find((user) => user.username === username);

        if (userData) {
            if (userData.password !== password) {
                setErrorMessages({ name: "pass", message: errors.pass });
            } else {
                setIsSubmitted(true);
            }
        } else {
            setErrorMessages({ name: "uname", message: errors.uname });
        }
    };

    const renderErrorMessage = (name) =>
        name === errorMessages.name && (
            <div className="error">{errorMessages.message}</div>
        );

    const renderForm = (
        <div className="form">
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label>Username </label>
                    <input
                        type="text"
                        name="uname"
                        required
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    {renderErrorMessage("uname")}
                </div>
                <div className="input-container">
                    <label>Password </label>
                    <input
                        type="password"
                        name="pass"
                        required
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    {renderErrorMessage("pass")}
                </div>
                <div className="button-container">
                    <input type="submit" />
                </div>
            </form>
        </div>
    );

    return (
        <div className="app">
            <div className="login-form">
                <div className="title">Sign In</div>
                {isSubmitted ? (
                    <div>User is successfully logged in</div>
                ) : (
                    renderForm
                )}
            </div>
        </div>
    );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);