var ws;

function connect() {
    var username = document.getElementById("username").value;
    var wsserver = "ws://localhost:8080/Chat/";
    var url = wsserver + username;

    ws = new WebSocket(url);

    ws.onmessage = function(event) {
        console.log(event.data);

        // display on browser
        var log = document.getElementById("log");
        log.innerHTML += event.data + "\n";
    };

    ws.onopen = function(event) {
        var log = document.getElementById("log");
        log.innerHTML += "Connected to \n  " + event.currentTarget.url + "\n";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    ws.send(content);
}

