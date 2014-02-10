jQuery(function($) {
    var connection = new WebSocket('ws://%%ip%%:%%port%%');

    connection.onopen = function()
    {
      tries = -1;
      console.log("Autoload - Connection established...");
    };

    connection.onmessage = function(evt)
    {
      if ("refresh" === event.data) {
        document.location.reload();
      }
    };
    connection.onclose = function()
    {
      console.log("Autoload - Connection is closed...");
    };
});