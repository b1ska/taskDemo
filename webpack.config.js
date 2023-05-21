const path = require('path');

module.exports = {
    entry: './src/main/resources/static/SweetCRM/js/App.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                },
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader'],
            },
        ],
    },
    devServer: {
        contentBase: path.resolve(__dirname, 'dist'),
        compress: true,
        port: 8089,
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/javascript',
        },
    },
};