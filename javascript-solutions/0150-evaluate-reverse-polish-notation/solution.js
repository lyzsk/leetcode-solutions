/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
    const stack = [];
    for (let token of tokens) {
        if (isNumber(token)) {
            stack.push(parseInt(token));
        } else {
            const num2 = stack.pop();
            const num1 = stack.pop();
            switch (token) {
                case "+":
                    stack.push(num1 + num2);
                    break;
                case "-":
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(num1 * num2);
                    break;
                case "/":
                    stack.push(
                        num1 / num2 > 0
                            ? Math.floor(num1 / num2)
                            : Math.ceil(num1 / num2)
                    );
                    break;
                default:
            }
        }
    }
    return stack.pop();
};

const isNumber = (token) => {
    return !(token === "+" || token === "-" || token === "*" || token === "/");
};
