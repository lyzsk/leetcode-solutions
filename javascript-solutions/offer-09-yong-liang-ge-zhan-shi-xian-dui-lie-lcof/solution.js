var CQueue = function () {
    this.inStack = [];
    this.outStack = [];
};

/**
 * @param {number} value
 * @return {void}
 */
CQueue.prototype.appendTail = function (value) {
    this.inStack.push(value);
};

/**
 * @return {number}
 */
CQueue.prototype.deleteHead = function () {
    if (!this.outStack.length) {
        if (!this.inStack.length) {
            return -1;
        }
        this.in2Out();
    }
    return this.outStack.pop();
};

CQueue.prototype.in2Out = function () {
    while (this.inStack.length) {
        this.outStack.push(this.inStack.pop());
    }
};
