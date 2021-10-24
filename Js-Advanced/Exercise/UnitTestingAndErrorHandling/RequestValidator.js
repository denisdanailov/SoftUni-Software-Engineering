function fn(obj) {

    const validMethods = ['GET', 'POST','DELETE','CONNECT'];
    const validVersions = ['HTTP/0.9','HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    const uriRegex = /(^[\w.]+$)/;
    const messageText = /([<>\\&'"])/;

    if (!obj.method || !validMethods.includes(obj.method)) {
        throw new Error(`Invalid request header: Invalid Method`)
    }

    if (!obj.version || !validVersions.includes(obj.version)) {
        throw new Error(`Invalid request header: Invalid Version`)
    }

    if (obj.message === undefined || messageText.test(obj.message)) {
        throw new Error(`Invalid request header: Invalid Message`)
    }

    if (!obj.uri || obj.uri === '' || !uriRegex.test(obj.uri)) {
        throw new Error(`Invalid request header: Invalid URI`)
    }

    return obj;
}




fn({
    method: 'GET',
    uri: 'git.hub',
    version: 'HTTP/0.9',
    message: ''
})