function rollDice() {
    // Roll dice for each player (random number between 1 and 6)
    const roll1 = Math.floor(Math.random() * 6) + 1;
    const roll2 = Math.floor(Math.random() * 6) + 1;
    const roll3 = Math.floor(Math.random() * 6) + 1;
    const roll4 = Math.floor(Math.random() * 6) + 1;

    // Display the roll results
    document.getElementById("roll1").textContent = roll1;
    document.getElementById("roll2").textContent = roll2;
    document.getElementById("roll3").textContent = roll3;
    document.getElementById("roll4").textContent = roll4;

    // Determine the winner
    const rolls = [roll1, roll2, roll3, roll4];
    const maxRoll = Math.max(...rolls);
    const winners = [];

    // Check for ties
    for (let i = 0; i < rolls.length; i++) {
        if (rolls[i] === maxRoll) {
            winners.push(`Player ${i + 1}`);
        }
    }

    // Display the winner or winners
    if (winners.length === 1) {
        document.getElementById("winner").textContent = `Winner: ${winners[0]}`;
    } else {
        document.getElementById("winner").textContent = `It's a tie between: ${winners.join(", ")}`;
    }
}
