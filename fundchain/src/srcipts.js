// Autocomplete for search
document.querySelector('input[name="search"]').addEventListener('input', async (e) => {
    const query = e.target.value;
    if (query.length > 2) {
        const response = await fetch(`/api/projects/search?q=${query}`);
        const suggestions = await response.json();
        // Display suggestions in a dropdown
    }
});

// WebSocket for notifications
const socket = new WebSocket('ws://localhost:8080/notifications');
socket.onmessage = (event) => {
    const notification = JSON.parse(event.data);
    showNotification(notification.message);
};