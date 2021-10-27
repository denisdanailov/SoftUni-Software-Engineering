function solve(tickets, criteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    const ticketsObj = [];

    tickets.forEach((entry) => {
        const [dest, price, status] = entry.split('|');
        ticketsObj.push(new Ticket(dest, Number(price), status));
    });

    if (criteria === 'destination') {
        ticketsObj.sort((a, b) => {
            return a.destination.localeCompare(b.destination);
        });
    } else if (criteria === 'status') {
        ticketsObj.sort((a, b) => {
            return a.status.localeCompare(b.status);
        });
    } else {
        ticketsObj.sort((a, b) => {
            return a.price - b.price;
        });
    }

    return ticketsObj;
}
